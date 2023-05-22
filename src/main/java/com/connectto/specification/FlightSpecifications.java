package com.connectto.specification;

import com.connectto.enums.Remarks;
import com.connectto.model.Airplane;
import com.connectto.model.Flight;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalTime;

public class FlightSpecifications {

    public static Specification<Flight> flightByDelayedOrCancelledForUser(String email) {
        return Specification.where(userEmailEqual(email))
                .and(remarksIn());
    }

    private static Specification<Flight> userEmailEqual(String email) {
        return (root, query, builder) -> builder.equal(root.join("book").join("user")
                .get("email"), email);
    }

    private static Specification<Flight> remarksIn() {
        return (root, query, builder) -> builder.or(
                builder.equal(root.join("airplane").get("remarks"), Remarks.DELAYYED),
                builder.equal(root.join("airplane").get("remarks"), Remarks.CANCELLED));
    }

    public static Specification<Flight> getAllAndSearchForAdmin(String cityDepartune, String cityArrival,
                                                                String timefrom, String timeto) {
        return Specification.where(cityDepartuneLike(cityDepartune)
                .and(cityArrivalLike(cityArrival))
                .and(timetoLike(timeto))
                .and(timefromLike(timefrom)));
    }

    public static Specification<Flight> getAllAndSearchForUsers(String cityDepartune, String cityArrival,
                                                                String timefrom, String timeto) {
        return Specification.where(cityDepartuneLike(cityDepartune)
                .and(cityArrivalLike(cityArrival))
                .and(timetoLike(timeto))
                .and(timefromLike(timefrom))
                .and(remarksEqual())
                .and(countEqual()));

    }

    private static Specification<Flight> cityDepartuneLike(String cityDepartune) {
        return (root, query, builder) -> cityDepartune != null ? builder.like(root.join("airplane")
                .get("cityDepartune"), "%" + cityDepartune + "%") : null;
    }

    private static Specification<Flight> cityArrivalLike(String cityArrival) {
        return (root, query, builder) -> cityArrival != null ? builder.like(root.join("airplane")
                .get("cityArrival"), "%" + cityArrival + "%") : null;
    }

    private static Specification<Flight> timefromLike(String timefrom) {
        return (root, query, builder) -> timefrom != null && !timefrom.isEmpty() ? builder.greaterThanOrEqualTo(root
                .join("airplane").get("timeArrivel"), LocalTime.parse(timefrom)) : null;
    }

    private static Specification<Flight> timetoLike(String timeto) {
        return (root, query, builder) -> timeto != null && !timeto.isEmpty() ? builder.lessThanOrEqualTo(root
                .join("airplane").get("timeArrivel"), LocalTime.parse(timeto)) : null;
    }

    private static Specification<Flight> remarksEqual() {
        return (root, query, builder) -> builder.equal(root.join("airplane").get("remarks"), Remarks.ON_TIME);
    }

    private static Specification<Flight> countEqual() {
        return (root, query, builder) -> builder.greaterThan(root.get("count"), 0);
    }


}
