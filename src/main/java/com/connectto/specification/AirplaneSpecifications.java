package com.connectto.specification;

import com.connectto.enums.Remarks;
import com.connectto.model.Airplane;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalTime;

public class AirplaneSpecifications {

    public static Specification<Airplane> getAllAndSearch(String cityDepartune, String cityArrival,
                                                          String remarks, String timeArrivel, String timeDepature) {
        return Specification.where(cityDepartuneLike(cityDepartune))
                .and(cityArrivalLike(cityArrival))
                .and(remarksEqual(remarks))
                .and(timeArrivelEqual(timeArrivel))
                .and(timeDepatureEqual(timeDepature));
    }

    private static Specification<Airplane> cityDepartuneLike(String cityDepartune) {
        return (root, query, builder) -> cityDepartune != null ? builder.like(root.
                get("cityDepartune"), "%" + cityDepartune + "%") : null;
    }

    private static Specification<Airplane> cityArrivalLike(String cityArrival) {
        return (root, query, builder) -> cityArrival != null ? builder.like(root.
                get("cityArrival"), "%" + cityArrival + "%") : null;
    }

    private static Specification<Airplane> remarksEqual(String remarks) {
        return (root, query, builder) -> remarks != null ? builder.equal(root.
                get("remarks"), Remarks.valueOf(remarks)) : null;
    }

    private static Specification<Airplane> timeArrivelEqual(String timeArrivel) {
        return (root, query, builder) -> timeArrivel != null ? builder.equal(root.
                get("timeArrivel"), LocalTime.parse(timeArrivel)) : null;
    }

    private static Specification<Airplane> timeDepatureEqual(String timeDepature) {
        return (root, query, builder) -> timeDepature != null ? builder.equal(root.
                get("timeDepature"), LocalTime.parse(timeDepature)) : null;
    }
}
