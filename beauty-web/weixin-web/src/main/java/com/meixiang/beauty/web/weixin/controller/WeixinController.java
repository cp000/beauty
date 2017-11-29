package com.meixiang.beauty.web.weixin.controller;

import com.meixiang.beauty.common.dto.ResponseDTO;
import com.meixiang.beauty.common.dto.wechat.WechatConfigDTO;
import com.meixiang.beauty.common.utils.*;
import com.meixiang.beauty.common.web.BaseController;
import com.meixiang.beauty.modules.wechat.api.WechatCoreService;
import com.meixiang.beauty.sys.entity.Article;
import com.meixiang.beauty.sys.entity.WechatBean;
import com.meixiang.beauty.sys.interceptor.SystemControllerLog;
import com.meixiang.beauty.sys.service.SystemService;
import com.meixiang.beauty.sys.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by chenjiake on 17/11/4.
 * 负责响应微商平台用户端微信公众平台的请求
 *
 */

@Controller
@RequestMapping(value = "")
public class WeixinController extends BaseController {

    @Autowired
    private WechatCoreService wechatCoreService;

    @Autowired
    private SystemService systemService;

    /**
     * *用户校验是否是微信服务器发送的请求
     * */
    @RequestMapping(value = "/business/wxChat", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String wxPatientChat(HttpServletRequest request,HttpServletResponse response) {
          String method = request.getMethod().toUpperCase();
          if ("GET".equals(method)) {
              // 微信加密签名
              String signature = request.getParameter("signature");
              // 时间戳
              String timestamp = request.getParameter("timestamp");
              // 随机数
              String nonce = request.getParameter("nonce");
              // 随机字符串
              String echostr = request.getParameter("echostr");

              // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
              if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                return echostr;
              }
              return "";
          } else {
              // 调用核心业务类接收消息、处理消息
              String respMessage = null;
              try {
                  respMessage = wechatCoreService.processWechatRequest(request,response);
              } catch (IOException e) {
                  e.printStackTrace();
              }
              return respMessage;
          }
      }

    /**
     * 公众号菜单引导页
     */
    @RequestMapping(value = "wechatInfo/getBusinessWechatMenuId", method = {RequestMethod.POST, RequestMethod.GET})
    public String getUserWechatMenu(HttpServletRequest request,
                                    HttpServletResponse response,
                                    HttpSession session) throws Exception
    {
        String code = request.getParameter("code");
        String url = java.net.URLDecoder.decode(request.getParameter("url"), "utf-8");

        if ("1".equals(url)) {
            //引导页
            url = ConstantUtil.TITAN_WEB_URL + "/titan/appoint#/guide";
            LogUtils.saveLog("引导页");
        } else if ("2".equals(url)) {
            //预约首页
            url = ConstantUtil.TITAN_WEB_URL + "/titan/firstPage/appoint";
            LogUtils.saveLog("预约首页");
        } else if ("3".equals(url)) {
            String state = request.getParameter("state");
            //接诊提醒
            url = ConstantUtil.TITAN_WEB_URL + "/titan/appoint#/userEvaluate/" + state;
            LogUtils.saveLog("接诊提醒");

        } else if ("4".equals(url)) {
            //郑玉巧育儿经
            url = ConstantUtil.WISDOM_WEB_URL + "/wisdom/firstPage/knowledge";
            LogUtils.saveLog("郑玉巧育儿经");
        } else if ("5".equals(url)) {
            //郑玉巧在线
            url = ConstantUtil.WISDOM_WEB_URL + "/wisdom/knowledge#/sheOnlineIndex";
            LogUtils.saveLog("郑玉巧在线");

        } else if ("6".equals(url)) {
            //我的预约
            url = ConstantUtil.TITAN_WEB_URL + "/titan/appoint#/myAppointment";
            LogUtils.saveLog("我的预约");

        } else if ("7".equals(url)) {
            url = ConstantUtil.TITAN_WEB_URL + "/titan/appoint#/operateIndex";
        } else if ("8".equals(url)) {
            url = ConstantUtil.TITAN_WEB_URL + "/titan/appoint#/operateIndex";
        } else if ("9".equals(url)) {
            url = ConstantUtil.TITAN_WEB_URL + "/titan/phoneConsult#/selfCenter";
        } else if ("20".equals(url)) {
            //扫码送周会员
            url = ConstantUtil.TITAN_WEB_URL + "/titan/appoint#/memberService/week,extend,";
        } else if ("23".equals(url)) {
            //赠送周会员
            url = ConstantUtil.TITAN_WEB_URL + "/titan/appoint#/memberService/week,extend,";
        } else if ("21".equals(url)) {
            //赠送月会员
            url = ConstantUtil.TITAN_WEB_URL + "/titan/appoint#/memberService/month,extend,";
        } else if ("22".equals(url)) {
            //赠送季会员
            url = ConstantUtil.TITAN_WEB_URL + "/titan/appoint#/memberService/quarter,extend,";
        }else if("10".equals(url)){
            //健康管理
            url = ConstantUtil.WISDOM_WEB_URL +"/wisdom/firstPage/healthPlan";
            LogUtils.saveLog("BMGL_36");
        }else if("23".equals(url)){
            url = ConstantUtil.WISDOM_WEB_URL + "/titan/appoint#/healthRecordIndex/0";
        }else if("24".equals(url)){
            url = ConstantUtil.KEEPER_WEB_URL + "/keeper/health#/consultBabyList";
        }else if("25".equals(url)){
            url = ConstantUtil.MARKET_WEB_URL + "/market/market#/consultBabyList";
        }else if("11".equals(url)){
            //运营活动
            String state = request.getParameter("state");
            if("HDSY_YDYW".equals(state)){
                LogUtils.saveLog("HDSY_YDYW");//从阅读原文打开活动首页
            }else if("FXSY_PYQ".equals(state)){
                LogUtils.saveLog("FXSY_PYQ");//从首页朋友圈打开活动首页
            }else if("FXSY_PYXX".equals(state)){
                LogUtils.saveLog("FXSY_PYXX");//从首页朋友消息打开活动首页
            }else if("HDSY_CD".equals(state)){
                LogUtils.saveLog("HDSY_CD");//从菜单打开活动首页
            }else if("FXJG_PYQ".equals(state)){
                LogUtils.saveLog("FXJG_PYQ");//从结果页朋友圈打开活动首页
            }else if("FXJG_PYXX".equals(state)){
                LogUtils.saveLog("FXJG_PYXX");//从结果页朋友圈打开活动首页
            }
            url = ConstantUtil.MARKET_WEB_URL +"market/firstPage/momNutritionTest";
        }else if("26".equals(url)){
            url = ConstantUtil.TITAN_WEB_URL + "titan/firstPage/antiDogFirst";
        }else if ("28".equals(url)){
            url = ConstantUtil.TITAN_WEB_URL + "/titan/firstPage/phoneConsult";
        }else if (url.indexOf("consultPhone")>-1){
            System.out.println("begin"+url);
            String departmentName  = URLEncoder.encode(url.replace("consultPhone",""), "UTF-8");
            url =ConstantUtil.TITAN_WEB_URL +"titan/phoneConsult#/phoneConDoctorList/"+departmentName+",searchDoctorByDepartment,";
            System.out.println("end"+url);
        }else if("29".equals(url)){
            //保险
            url = ConstantUtil.TITAN_WEB_URL + "titan/firstPage/insurance";
        }else if("30".equals(url)){
            //保险
            url = ConstantUtil.TITAN_WEB_URL + "titan/insurance#/handfootmouthIndex";
        }else if(url.indexOf("umbrella")>-1){
            String[] state = url.replace("umbrella","").split("_");
            if(state.length>1) {
                String id = state[1];
                String status = state[0];
                url = ConstantUtil.WISDOM_WEB_URL + "wisdom/firstPage/umbrella?status="+status+"&id="+id+"&time="+new Date().getTime();
            }else{
                String status = state[0];
                url = ConstantUtil.WISDOM_WEB_URL + "wisdom/firstPage/umbrella?time="+new Date().getTime()+"&status="+status;
            }
        }else if("31".equals(url)){
            url = ConstantUtil.WISDOM_WEB_URL + "wisdom/umbrella#/umbrellaJoin/"+new Date().getTime()+"/120000000";
        }else if("32".equals(url)){
            url = ConstantUtil.WISDOM_WEB_URL + "wisdom/firstPage/lovePlan";
        }else if("33".equals(url)){
            url = ConstantUtil.WISDOM_WEB_URL + "wisdom/umbrella#/umbrellaInvite";
        }else if("35".equals(url)){
            url = ConstantUtil.KEEPER_WEB_URL + "keeper/wxPay/patientPay.do?serviceType=doctorConsultPay";
        }else if("34".equals(url)){
            url = ConstantUtil.ANGEL_WEB_URL + "angel/patient/consult#/customerService";
        }

        String get_access_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
                "appid="+ ConstantUtil.CORPID +
                "&secret=" + ConstantUtil.SECTET +
                "&code="+ code +
                "&grant_type=authorization_code";
        String access_token = "";
        String openid = "";
        if (access_token.isEmpty() && openid.isEmpty()) {
            WechatBean wechat;
            int countNum = 0;
            do {
                String json = HttpRequestUtil.getConnectionResult(get_access_token_url, "GET", "");
                wechat = JsonUtil.getObjFromJsonStr(json, WechatBean.class);
                if (countNum++ > 3) {
                    break;
                }
            } while (wechat == null);

            openid = wechat.getOpenid();
            session.setAttribute("openId", openid);
            CookieUtils.setCookie(response, "openId", openid==null?"":openid,60*60*24*30,ConstantUtil.DOMAIN_VALUE);
        }
        return "redirect:" + url;
    }


    /**
     * 用户端微信JS-SDK获得初始化参数
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "wechatInfo/getConfig", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseDTO<WechatConfigDTO> getConfig(HttpServletRequest request) throws Exception
    {
        ResponseDTO<WechatConfigDTO> wechatConfigDTOResponseDTO = new ResponseDTO<>();
        String u = request.getParameter("url");
        Map<String, Object> parameter = systemService.getWechatParameter();
        String ticket = (String) parameter.get("ticket");
        WechatConfigDTO wechatConfigDTO = JsApiTicketUtil.sign(ticket, u);
        wechatConfigDTOResponseDTO.setResponseData(wechatConfigDTO);
        return wechatConfigDTOResponseDTO;
    }

    /**
     * 验证主入口
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/fieldwork/wechat/author", method = RequestMethod.GET)
    public String Oauth2API(HttpServletRequest request) {
        String backUrl = request.getParameter("url");
        String oauth2Url = WechatUtil.getOauth2Url(backUrl);
        return "redirect:" + oauth2Url;
    }

    /**
     * 向微信客户端推送消息
     */
    @RequestMapping(value = "wechatInfo/postInfoToWechat", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    @SystemControllerLog(description = "00000084")//咨询医生消息推送
    String
    sendMsgToWechat(HttpServletRequest request, HttpSession session) {
        String openId = (String) session.getAttribute("openId");
        if (!StringUtils.isNotNull(openId)) {
            openId = CookieUtils.getCookie(request, "openId");
        }

        Map<String, Object> parameter = systemService.getWechatParameter();
        String token = (String) parameter.get("token");

        List<Article> articleList = new ArrayList<Article>();
        Article article = new Article();
        article.setTitle("三甲医院儿科专家    咨询秒回不等待");
        article.setDescription("小儿内科:       24小时全天 \n\n小儿皮肤科/保健科:   8:00 ~ 23:00\n\n妇产科:   12:00-14:00，19:00-22:00\n" +
                "\n小儿其他专科:   19:00 ~ 21:00\n\n" +
                "(外科、眼科、耳鼻喉科、口腔科、预防接种科、中医科、心理科)\n\n好消息！可在线咨询北京儿童医院皮肤科专家啦！");
        article.setPicUrl("http://xiaoerke-wxapp-pic.oss-cn-hangzhou.aliyuncs.com/menu/%E6%8E%A8%E9%80%81%E6%B6%88%E6%81%AF2.png");
        article.setUrl("https://mp.weixin.qq.com/s?__biz=MzI2MDAxOTY3OQ==&mid=504236660&idx=1&sn=10d923526047a5276dd9452b7ed1e302&scene=1&srcid=0612OCo7d5ASBoGRr2TDgjfR&key=f5c31ae61525f82ed83c573369e70b8f9b853c238066190fb5eb7b8640946e0a090bbdb47e79b6d2e57b615c44bd82c5&ascene=0&uin=MzM2NjEyMzM1&devicetype=iMac+MacBookPro11%2C4+OSX+OSX+10.11.4+build(15E65)&version=11020201&pass_ticket=dG5W6eOP3JU1%2Fo3JXw19SFBAh1DgpSlQrAXTyirZuj970HMU7TYojM4D%2B2LdJI9n");
        articleList.add(article);
        WechatUtil.senImgMsgToWechat(token,openId,articleList);

        if (openId != null) {
            return "true";
        }
        return "false";
    }

}
