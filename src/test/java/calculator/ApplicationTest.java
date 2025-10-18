package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 숫자합_테스트(){
        assertSimpleTest(() -> {
            run("12:13:14");
            assertThat(output().contains("결과 : 39"));
        });
    }

    @Test
    void 음수가_들어오는_경우_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-5,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void int를_넘어간_경우_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-10000000000000000000,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
