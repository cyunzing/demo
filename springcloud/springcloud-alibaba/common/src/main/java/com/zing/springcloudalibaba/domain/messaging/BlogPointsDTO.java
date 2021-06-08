package com.zing.springcloudalibaba.domain.messaging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zing
 * @date 2020-07-12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlogPointsDTO {

    private Long userId;
    private Integer points;

}
