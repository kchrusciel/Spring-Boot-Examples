package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description "Should return user"

    request {
        method("GET")
        url("/")
    }

    response {
        status 200
        body(["id":1, "name": "CodeCouple.pl"])
        headers {
            contentType("application/json")
        }
    }

}