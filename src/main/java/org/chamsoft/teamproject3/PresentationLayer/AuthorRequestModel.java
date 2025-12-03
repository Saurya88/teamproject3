package org.chamsoft.teamproject3.PresentationLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorRequestModel {
    @JsonProperty("fname")
    private String fName;

    @JsonProperty("lname")
    private String lName;
}
