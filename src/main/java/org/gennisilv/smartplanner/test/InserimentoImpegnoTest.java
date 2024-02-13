package org.gennisilv.smartplanner.test;
import org.gennisilv.smartplanner.data.Impegno;
import org.gennisilv.smartplanner.data.ListaDAO;
import org.gennisilv.smartplanner.logic.ListaLogic;
import org.gennisilv.smartplanner.logic.UtenteLogic;
import org.junit.Test;
import static org.junit.Assert.*;

public class InserimentoImpegnoTest {
    @Test
    public void testInserimentoImpegnoNomeInvalido()
    {
        UtenteLogic.login("silvanacafaro256@gmail.com","Zzilv1234!");
        Impegno i1= new Impegno();
        i1.setNomeImpegno("NomeImpegno&");
        i1.setDurataImpegno(60);
        i1.setPrioritaImpegno(2);
        assertEquals(2,ListaLogic.aggiungiImpegno(i1.getNomeImpegno(),i1.getDurataImpegno(),i1.getPrioritaImpegno()));
    }
    @Test
    public void testInserimentoImpegnoDurataMinore()
    {
        UtenteLogic.login("silvanacafaro256@gmail.com","Zzilv1234!");
        Impegno i2 = new Impegno();
        i2.setNomeImpegno("NomeImpegno2");
        i2.setDurataImpegno(20);
        i2.setPrioritaImpegno(2);
        assertEquals(-1,ListaLogic.aggiungiImpegno(i2.getNomeImpegno(),i2.getDurataImpegno(),i2.getPrioritaImpegno()));
    }
    @Test
    public void testInserimentoImpegnoInserito()
    {
        UtenteLogic.login("silvanacafaro256@gmail.com","Zzilv1234!");
        Impegno i3 = new Impegno();
        i3.setNomeImpegno("NomeImpegno");
        i3.setDurataImpegno(60);
        i3.setPrioritaImpegno(2);
        assertEquals(1,ListaLogic.aggiungiImpegno(i3.getNomeImpegno(), i3.getDurataImpegno(), i3.getPrioritaImpegno()));
    }

}
