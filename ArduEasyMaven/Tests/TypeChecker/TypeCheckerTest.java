package TypeChecker;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class TypeCheckerTest
{
    @Deployment
    public static JavaArchive createDeployment()
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(TypeChecker.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @org.junit.Test
    public void visit()
    {
    }

    @org.junit.Test
    public void visit1()
    {
    }

    @org.junit.Test
    public void visit2()
    {
    }

    @org.junit.Test
    public void visit3()
    {
    }

    @org.junit.Test
    public void visit4()
    {
    }

    @org.junit.Test
    public void visit5()
    {
    }

    @org.junit.Test
    public void visit6()
    {
    }

    @org.junit.Test
    public void visit7()
    {
    }

    @org.junit.Test
    public void visit8()
    {
    }

    @org.junit.Test
    public void visit9()
    {
    }

    @org.junit.Test
    public void visit10()
    {
    }

    @org.junit.Test
    public void visit11()
    {
    }

    @org.junit.Test
    public void visit12()
    {
    }

    @org.junit.Test
    public void visit13()
    {
    }

    @org.junit.Test
    public void visit14()
    {
    }

    @org.junit.Test
    public void visit15()
    {
    }

    @org.junit.Test
    public void visit16()
    {
    }

    @org.junit.Test
    public void visit17()
    {
    }

    @org.junit.Test
    public void visit18()
    {
    }

    @org.junit.Test
    public void visit19()
    {
    }

    @org.junit.Test
    public void visit20()
    {
    }

    @org.junit.Test
    public void visit21()
    {
    }

    @org.junit.Test
    public void visit22()
    {
    }

    @org.junit.Test
    public void visit23()
    {
    }

    @org.junit.Test
    public void visit24()
    {
    }

    @org.junit.Test
    public void visit25()
    {
    }

    @org.junit.Test
    public void visit26()
    {
    }

    @org.junit.Test
    public void visit27()
    {
    }

    @org.junit.Test
    public void visit28()
    {
    }

    @org.junit.Test
    public void visit29()
    {
    }

    @org.junit.Test
    public void visit30()
    {
    }

    @org.junit.Test
    public void visit31()
    {
    }

    @org.junit.Test
    public void visit32()
    {
    }

    @org.junit.Test
    public void visit33()
    {
    }

    @org.junit.Test
    public void visit34()
    {
    }

    @org.junit.Test
    public void visit35()
    {
    }

    @org.junit.Test
    public void visit36()
    {
    }

    @org.junit.Test
    public void visit37()
    {
    }

    @org.junit.Test
    public void visit38()
    {
    }

    @org.junit.Test
    public void visit39()
    {
    }

    @org.junit.Test
    public void visit40()
    {
    }

    @org.junit.Test
    public void visit41()
    {
    }

    @org.junit.Test
    public void visit42()
    {
    }

    @org.junit.Test
    public void visit43()
    {
    }

    @org.junit.Test
    public void visit44()
    {
    }

    @org.junit.Test
    public void visit45()
    {
    }

    @org.junit.Test
    public void visit46()
    {
    }

    @org.junit.Test
    public void visit47()
    {
    }

    @org.junit.Test
    public void visit48()
    {
    }

    @org.junit.Test
    public void visit49()
    {
    }
}
