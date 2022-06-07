package kr.co.patternbot.faq.domains;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Entity
@Table(name = "faqs")
public class Faq {
    @Id @Column(name = "faqid")
    @GeneratedValue private long faqid;
    @Column private @NotNull String question;
    @Column private @NotNull String answer;
}
