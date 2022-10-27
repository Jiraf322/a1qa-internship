import selenium.webdriver as webdriver
from selenium.webdriver.chrome.service import Service as ChromeService
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.ie.service import Service as IEService
from webdriver_manager.microsoft import IEDriverManager

from Framework.Utils.json_getter import JsonGetter
from Framework.Resources.json_path import JsonPath
from Framework.Utils.logger import Logger


class BrowserFactory:
    @staticmethod
    def get_webdriver():
        browser_config_path = JsonPath.framework_config
        # browser_config_path = r"C:\Users\USER\OneDrive\Рабочий стол\last_task\Framework\Resources\config.json"
        browser_name = JsonGetter.get_data(data_1="DriverConfig", data_2="BrowserName", path=browser_config_path)
        options = JsonGetter.get_data(data_1="DriverConfig", data_2="Options", path=browser_config_path)

        Logger().catch_info(f'launching {browser_name}')
        if browser_name == 'firefox':
            option = webdriver.FirefoxOptions()
            for element in options:
                option.add_argument(element)
            return webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()), options=option)

        elif browser_name == 'chrome':
            option = webdriver.ChromeOptions()
            for element in options:
                option.add_argument(element)
            return webdriver.Chrome(service=ChromeService(ChromeDriverManager().install()), options=option)

        elif browser_name == 'ie':
            option = webdriver.IeOptions()
            for element in options:
                option.add_argument(element)
            return webdriver.Ie(service=IEService(IEDriverManager().install()), options=option)

        Logger().catch_warning(f'No such {browser_name} browser name exists')
        raise Exception("No such " + browser_name + " browser exists")
