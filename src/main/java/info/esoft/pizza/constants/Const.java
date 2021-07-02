package info.esoft.pizza.constants;

public interface Const {
    interface SyteInfo{
        String TITLE_SYTE = "Доставка пиццы в Кемерово - Пиццуля";
        String LINK_SYTE = "https://пиццуля42.рф";
    }

    interface Errors{
        String PROMOCODE_ERROR = "Промокод не корректен. Проверьте информацию об акции и попробуйте еще раз!";
        String BASKET_EMPTY = "В вашей корзине нет ни одного товара";

    }

    interface ClassButton{
        String BUTTON_DISABLED = "button-disabled";
    }

    interface Menu{
        String TEXT_MY_ACCOUNT = "Мой аккаунт";
        String TEXT_BASKET = "Корзина";
    }

    interface ServiceSmsCode{
        String SYTE_GET_SMS_CODE = "wss://stream.pushbullet.com/websocket/o.Z77alssDKwkTsgyTpRr6q6EoOJIgSECm";
        Integer TIMEOUT = 5000;
    }

    interface AllWebDrivers{
        String PATH_GOOGLE_DRIVER = "/Users/user/Downloads/chromedriver";
        String NAME_GOOGLE_DRIVER = "webdriver.chrome.driver";

        String PATH_SAFARI_DRIVER = "/usr/bin/safaridriver";
        String NAME_SAFARI_DRIVER = "webdriver.safari.driver";

        String PATH_FIRE_FOX_DRIVER = "/Users/user/Downloads/firefoxdriver";
        String NAME_FIRE_FOX_DRIVER = "webdriver.gecko.driver";
    }

}
