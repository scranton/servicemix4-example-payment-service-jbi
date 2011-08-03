/*
 * Copyright 2011 FuseSource
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.example.fuse.payment_service;

import com.example.fuse.payment_service.types.Response;
import com.example.fuse.payment_service.types.Transfer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;

public class PaymentImpl implements Payment, InitializingBean {
    private static final Log LOG = LogFactory.getLog(PaymentImpl.class);

    public Response transferFunds(Transfer payload) {
        Response response = new Response();

        LOG.info("Transfered amount " + payload.getAmount()
                + " from " + payload.getFrom()
                + " to " + payload.getTo());

        response.setReply("OK");

        return response;
    }

    public void afterPropertiesSet() throws Exception {
        LOG.info("PaymentImpl afterPropertiesSet");
    }
}
