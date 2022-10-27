from Framework.Browser.browser_factory import BrowserFactory
from Framework.Browser.singleton import MetaClassSingleton


class Driver(metaclass=MetaClassSingleton):
    __driver = None

    def get_instance(self):
        if self.__driver is None:
            self.__driver = BrowserFactory.get_webdriver()
        return self.__driver

    def driver_quit(self):
        if self.__driver is not None:
            self.__driver.quit()
            self.__driver = None
