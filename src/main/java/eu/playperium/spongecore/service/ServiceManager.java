/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package eu.playperium.spongecore.service;

import java.util.ArrayList;

public class ServiceManager {

    private ArrayList<InternalService> internalServices = new ArrayList<>();

    public void registerInternalService(InternalService service) {
        internalServices.add(service);
    }
    
    public void loadServices() {
        for (InternalService service: internalServices) {
            service.execute();
        }
    }
}
