package br.tec.lvconsult.applications.configs;

import br.tec.lvconsult.applications.utils.ILvMath;
import br.tec.lvconsult.applications.utils.ILvNumber;
import br.tec.lvconsult.applications.utils.LvMathImpl;
import br.tec.lvconsult.applications.utils.LvNumberImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class appConfig {

    @Bean
    public ILvNumber lvNumber() {
        return new LvNumberImpl();
    }

    @Bean
    public ILvMath lvMath() {
        return new LvMathImpl();
    }
}
