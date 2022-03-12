package com.estock.api.dto;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class CredentialDetailDTO extends CredentialDTO {
    private String roleName;
}
