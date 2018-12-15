/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package eu.playperium.spongecore.service

import java.util.*

class ServiceManager {
    private var internalServices: ArrayList<InternalService> = ArrayList()

    fun registerInternalService(service: InternalService) {
        internalServices.add(service)
    }

    fun loadServices() {
        for (service: InternalService in internalServices) {
            service.execute()
        }
    }
}
