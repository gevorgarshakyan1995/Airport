package com.connectto.specification;

import com.connectto.enums.Remarks;
import com.connectto.model.Flight;
import org.springframework.data.jpa.domain.Specification;

public class FlightSpecifications {

    public static Specification<Flight> flightByDelayedOrCancelledForUser(String email) {
        return Specification.where(userEmailEqual(email))
              .and(remarksIn());
    }

    private static Specification<Flight> userEmailEqual(String email) {
        return (root, query, builder) -> builder.equal(root.join("book").join("user").get("email"), email );
    }

    private static Specification<Flight> remarksIn() {
        return (root, query, builder) -> builder.or(
                builder.equal(root.join("airplane").get("remarks"), Remarks.DELAYYED),
                builder.equal(root.join("airplane").get("remarks"), Remarks.CANCELLED));
    }
}
