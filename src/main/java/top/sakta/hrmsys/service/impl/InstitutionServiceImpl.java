package top.sakta.hrmsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sakta.hrmsys.domain.Institution;
import top.sakta.hrmsys.mapper.InstitutionMapper;
import top.sakta.hrmsys.service.InstitutionService;

import java.util.List;

@Service
public class InstitutionServiceImpl implements InstitutionService {

    @Autowired
    private InstitutionMapper institutionMapper;

    @Override
    public Institution getInstitutionByID(String iID) {
        return institutionMapper.getInstitutionByID(iID);
    }

    @Override
    public List<Institution> getAllInstitutions() {
        return institutionMapper.getAllInstitutions();
    }

    @Override
    public int insertInstitution(Institution institution) {
        return institutionMapper.insertInstitution(institution);
    }

    @Override
    public int updateInstitution(Institution institution) {
        return institutionMapper.updateInstitution(institution);
    }

    @Override
    public int deleteInstitution(String rID) {
        return institutionMapper.deleteInstitution(rID);
    }
}
