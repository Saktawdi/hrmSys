package top.sakta.hrmsys.service;

import top.sakta.hrmsys.domain.Institution;

import java.util.List;

/**
 * Mapper 机构Service
 * @author Quescc
 * @version 1.0
 * @data 2023年12月23日
 */

public interface InstitutionService {
    Institution getInstitutionByID(String iID);

    List<Institution> getAllInstitutions();

    int insertInstitution(Institution institution);

    int updateInstitution(Institution institution);

    int deleteInstitution(String rID);

    List<Institution> getInstitutionsByLevel(Integer iLevel);

    List<Institution> getInstitutionsByLevelAndParent(Integer iLevel,String iParent);

    List<Institution> getInstitutionsByParent(String iParent);
}
