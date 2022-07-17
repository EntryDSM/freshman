package kr.hs.entrydsm.freshman.domain.user.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 6, max = 24)
    @NotNull
    private String accountId;

    @Length(min = 60, max = 60)
    @NotNull
    private String password;

    @NotNull
    @Length(min = 2, max = 10)
    private String name;

    private String profileImageUrl;

    @Length(min = 1, max = 20)
    private String introduce;

    @Builder
    public User(String accountId, String password, String name) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
    }

    public void update(String name, String introduce, String profileImageUrl) {
        this.name = name;
        this.introduce = introduce;
        this.profileImageUrl = profileImageUrl;
    }

}
