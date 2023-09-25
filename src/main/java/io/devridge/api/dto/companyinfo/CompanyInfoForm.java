package io.devridge.api.dto.companyinfo;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class CompanyInfoForm {

    @NotEmpty(message = "회사 이름 필드가 비어있습니다.")
    private String companyName;

    @NotEmpty(message = "직무 이름 필드가 비어있습니다.")
    private String jobName;

    @NotEmpty(message = "서비스 종류 이름 필드가 비어있습니다.")
    private String detailedPositionName;

    private String content;

}
