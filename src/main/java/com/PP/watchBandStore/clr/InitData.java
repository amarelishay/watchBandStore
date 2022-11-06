package com.PP.watchBandStore.clr;


import com.PP.watchBandStore.beans.Band;
import com.PP.watchBandStore.beans.Colors;
import com.PP.watchBandStore.beans.Type;
import com.PP.watchBandStore.beans.User;
import com.PP.watchBandStore.services.BandService;
import com.PP.watchBandStore.services.WelcomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitData implements CommandLineRunner {
  private final BandService bandService;
  private final WelcomeService welcomeService;

    @Override
    public void run(String... args) throws Exception {
        Band band= Band.builder().name("class").price(64).discount(50)
                .size(42)
                .type(Type.REGULAR)
                .color(Colors.BLUE)
                .image("https://file.rendit.io/n/4yAgzhSfOiDjMltKzj5q.png")
                .build();
        bandService.addBand(band);
        Band band1= Band.builder().name("band1").price(100).discount(50)
                .size(44)
                .type(Type.REGULAR)
                .color(Colors.SKYBLUE)
                .image("https://file.rendit.io/n/JzUPpxNVeQcCKJeCst1D.png")
                .build();
        bandService.addBand(band1);
        Band band2= Band.builder().name("band2").price(100).discount(50)
                .size(44)
                .type(Type.REGULAR)
                .color(Colors.RED)
                .image("https://file.rendit.io/n/Cnm9hjsJnQLuRZfHvZ7M.png")
                .build();
        bandService.addBand(band2);
        Band band3= Band.builder().name("band2").price(100).discount(50)
                .size(44)
                .type(Type.REGULAR)
                .color(Colors.RED)
                .image("https://file.rendit.io/n/Cnm9hjsJnQLuRZfHvZ7M.png")
                .build();
        bandService.addBand(band3);
        Band band4= Band.builder().name("band2").price(100).discount(50)
                .size(44)
                .type(Type.REGULAR)
                .color(Colors.RED)
                .image("https://file.rendit.io/n/Cnm9hjsJnQLuRZfHvZ7M.png")
                .build();
        bandService.addBand(band4);
        Band band5= Band.builder().name("band2").price(100).discount(50)
                .size(44)
                .type(Type.REGULAR)
                .color(Colors.RED)
                .image("https://file.rendit.io/n/Cnm9hjsJnQLuRZfHvZ7M.png")
                .build();
        bandService.addBand(band5);
        Band band6= Band.builder().name("band2").price(100).discount(50)
                .size(44)
                .type(Type.REGULAR)
                .color(Colors.RED)
                .image("https://file.rendit.io/n/Cnm9hjsJnQLuRZfHvZ7M.png")
                .build();
        bandService.addBand(band6);
        Band band7= Band.builder().name("band2").price(100).discount(50)
                .size(44)
                .type(Type.REGULAR)
                .color(Colors.RED)
                .image("https://file.rendit.io/n/Cnm9hjsJnQLuRZfHvZ7M.png")
                .build();
        bandService.addBand(band7);
        Band band8= Band.builder().name("band2").price(95)
                .size(44)
                .type(Type.REGULAR)
                .color(Colors.RED)
                .image("https://file.rendit.io/n/Kbq2ysgt68LQVpnMB2Qx.png")
                .build();
        bandService.addBand(band8);
        Band band9= Band.builder().name("band2").price(110)
                .size(44)
                .type(Type.REGULAR)
                .color(Colors.RAINBOW)
                .image("https://file.rendit.io/n/FtzjpljLCfs9mpG5Zr5M.png")
                .build();
        bandService.addBand(band9);
        Band band10= Band.builder().name("band2").price(95)
                .size(44)
                .type(Type.REGULAR)
                .color(Colors.DARK_BLUE)
                .image("https://file.rendit.io/n/7zCforSsnILxfvKXxDFo.png")
                .build();
        bandService.addBand(band10);
        User user= User.builder().email("elishay61@gmail.com").password("1234").build();
        welcomeService.register(user);
        bandService.addToCart(2, user);
        System.out.println(user);
    }
}
