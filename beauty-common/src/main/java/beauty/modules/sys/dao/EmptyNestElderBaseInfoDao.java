package beauty.modules.sys.dao;

import beauty.common.persistence.annotation.MyBatisDao;
import beauty.common.dto.practitioner.healthService.EmptyNestElderBaseInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sunxiao on 2017/7/8.
 */
@MyBatisDao
@Repository
public interface EmptyNestElderBaseInfoDao {

    public void importEmptyElderBaseInfo(EmptyNestElderBaseInfo vo);

    public List<EmptyNestElderBaseInfo> getAllEmptyElderBaseInfo();
}
