package kr.co.patternbot.faqs.domains;

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
    @GeneratedValue private long faqid; //FAQ ID
    @Column private @NotNull String question; //질문
    @Column private @NotNull String answer; //답
}
