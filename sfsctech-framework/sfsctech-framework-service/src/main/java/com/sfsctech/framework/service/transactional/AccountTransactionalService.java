package com.sfsctech.framework.service.transactional;

import com.sfsctech.framework.model.domain.TSysAccount;

/**
 * Class AccountTransactionalService
 *
 * @author 张麒 2017/5/28.
 * @version Description:
 */
public interface AccountTransactionalService {
    Long save(TSysAccount account);
}
