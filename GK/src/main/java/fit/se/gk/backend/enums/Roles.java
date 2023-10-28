package fit.se.gk.backend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Roles {
    ADMINSTRATION(2),
    STAFF(1),
    MANAGER(0),
    EXECUTIVE(-1);
    private int role;
}
