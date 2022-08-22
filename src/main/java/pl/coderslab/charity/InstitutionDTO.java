package pl.coderslab.charity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.SecondaryTable;

@Getter
@Setter
public class InstitutionDTO {
    private Institution institutionOne;
    private Institution institutionTwo;

}
