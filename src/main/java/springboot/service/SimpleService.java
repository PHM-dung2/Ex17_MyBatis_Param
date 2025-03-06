package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.dao.ISimpleBbsDao;
import springboot.dto.SimpleBbsDto;

import java.util.List;
import java.util.Map;

@Service
public class SimpleService implements ISimpleService {

    @Autowired
    ISimpleBbsDao dao;

    @Override
    public List<SimpleBbsDto> list( ){
        return dao.listDao();
    } // f end

    @Override
    public SimpleBbsDto view( String id ){
        return dao.viewDao(id);
    } // f end

    @Override
    public int write(Map<String, String> map){
        int nResult = dao.writeDao(map);
        return nResult;
    } // f end

    @Override
    public int delete(String id){
        int nResult = dao.deleteDao(id);
        return nResult;
    } // f end

    @Override
    public int count(){
        int nTotalCount = dao.articleCount();
        return nTotalCount;
    } // f end

}
