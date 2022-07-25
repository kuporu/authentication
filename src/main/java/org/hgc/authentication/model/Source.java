package org.hgc.authentication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Source {

    private Long id;

    private Long userId;

    private Date lastLoginTime;

    private String weatherId;
}
