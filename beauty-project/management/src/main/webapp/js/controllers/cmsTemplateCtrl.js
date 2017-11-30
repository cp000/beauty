angular.module('controllers',[]).controller('cmsTemplateCtrl',
    ['$scope','$interval','$rootScope','$stateParams','$state','Global','$timeout',
        function ($scope,$interval,$rootScope,$stateParams,$state,Global,$timeout) {


            $scope.loadPageList = function(){}





            $timeout(function(){
                //calendar
                $(".date-picker").datepicker({
                    language: "zh-CN",
                    autoclose: true
                });
            },1000)

            //新增查看模板内容
            $scope.popup = function(type){
                $scope.templateAlert = true;
                if(type == 'new'){
                    $scope.type = 'new';
                    $scope.title = '新增';
                }
                else{
                    $scope.type = 'edit';
                    $scope.title = '修改';
                }
            }
            $scope.close = function()
            {
                $scope.templateAlert = false;
            }

            /*保存*/
            var submitOnOff = true;        //防止多次提交
            $scope.subUsersForm = function(isValid)
            {
                if(isValid){
                    // if(submitOnOff) {
                    submitOnOff = false;
                    if($scope.type == 'new'){

                    }else if($scope.type == 'edit'){

                    }
                    // }
                }else{
                    alert('信息不完整')
                }
            }

            //删除
            $scope.delFun = function(id){
                // DelMember.get({id:id},function(data){
                //     if(data.result == Global.SUCCESS){
                $scope.alertInfo = false;
                $scope.loadPageList();
                // }
                // })
            }



        }])