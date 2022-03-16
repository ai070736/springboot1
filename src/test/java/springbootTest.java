import com.simk.entities.BillProvider;
import com.simk.entities.Provider;
import com.simk.mapper.BillMapper;
import com.simk.mapper.ProviderMapper;
import com.simk.springMain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = springMain.class)
public class springbootTest {
    @Autowired
    ProviderMapper providerMapper;
    @Autowired
    BillMapper billMapper;
    @Test
    public void test(){
//        Provider providerByPid = providerMapper.getProviderByPid(1);
//        System.out.println(providerByPid);
        List<BillProvider> bills = billMapper.getBills(null);
        System.out.println(bills);
    }
}
