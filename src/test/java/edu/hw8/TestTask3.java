package edu.hw8;

import org.junit.jupiter.api.Test;
import java.util.Objects;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask3 {
    @Test
    void readTest() {
        var a = Task3.read("/Users/error404/Tink_java/src/main/java/edu/hw8/a.txt");
        var ans =
            "{afa03135b5d8434d1876aac9e4f67637=e.e.eee, a8597f533a539bdf3f00382bae0ad9f9=j.j.jjj, f65be1f85b3216c95d8892fc00a62ee8=o.o.ooo, 76d80224611fc919a5d54f0ff9fba446=f.f.fff, 3baa17a431e58749ffd6db3bedaa25b0=i.i.iii, 4124bc0a9335c27f086f24ba207a4912=b.b.bbb, 9975ebce30ce7c0a45d4cb9625fa153d=l.l.lll, bfa43b23261d818f5799e65c12188dfb=p.p.ppp, fbade9e36a3f36d3d676c1b808451dd7=c.c.ccc, 962012d09b8170d912f0669f6d7d9d07=n.n.nnn, e49357f9694f75e851b2383cb86d53ea=g.g.ggg, 5eaada35b4af18101bf647ec68ff7d7f=k.k.kkk, 0cc175b9c0f1b6a831c399e269772661=a.a.aaa, 631af02da41c8b3d8a222030d58d104d=h.h.hhh, 3817c93b7ba74074e8a5f4d3531fee58=m.m.mmm, e2187f93cbdbbe839cfae501b5362ace=d.d.ddd}";
        assert a != null;
        assertThat(ans).isEqualTo(a.toString());
    }

    @Test
    void nexPasswordTest() {
        var a = Task3.nextPassword("a", 1173);
        assertThat("av").isEqualTo(a);
    }

    @Test
    void countMD5Hash() {
        var a = "a";
        assertThat("0cc175b9c0f1b6a831c399e269772661").isEqualTo(Task3.countMD5Hash("a"));
    }

    @Test
    void checkPasswordTest() {
        var a = Task3.read("/Users/error404/Tink_java/src/main/java/edu/hw8/a.txt");
        var ans =
            "{aa=b.b.bbb, l0e=d.d.ddd, a=a.a.aaa, 0oa=h.h.hhh, zl4=k.k.kkk, 5td=e.e.eee, 8ols=o.o.ooo, qwer=n.n.nnn, 1sp=g.g.ggg, uyr=j.j.jjj, 2q0=i.i.iii, z0az=l.l.lll, z=c.c.ccc, z6aj=m.m.mmm, qwe=f.f.fff, 8q7=p.p.ppp}";
        assertThat(ans).isEqualTo(Objects.requireNonNull(Task3.checkPassword(a)).toString());
    }
}
