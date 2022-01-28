package com.api.stockmanagement.provider.userdetails.data.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthorityAdapter {
    private int id;
    private String name;
}
