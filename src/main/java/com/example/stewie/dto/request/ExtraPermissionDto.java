package com.example.stewie.dto.request;

import com.example.stewie.dto.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExtraPermissionDto extends BaseDto {


    private Long permissionId;

    private Long userId;

}
