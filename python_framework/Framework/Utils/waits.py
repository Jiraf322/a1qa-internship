from selenium.webdriver.support.ui import WebDriverWait as Wait
from selenium.webdriver.support import expected_conditions as EC

from Framework.Resources.json_path import JsonPath
from Framework.Utils.json_getter import JsonGetter
from Framework.Browser.driver import Driver

import os


class Waits:

    def __init__(self):
        browser_config_path = JsonPath.framework_config
        # browser_config_path = r"C:\Users\USER\OneDrive\Рабочий стол\last_task\Framework\Resources\config.json"
        self.timeout = JsonGetter().get_data(data_1="timeout", path=browser_config_path)

    def wait_element_visible(self, locator):
        return Wait(Driver().get_instance(), self.timeout).until(EC.visibility_of_element_located(locator))

    def wait_element_clickable(self, locator):
        return Wait(Driver().get_instance(), self.timeout).until(EC.element_to_be_clickable(locator))

    def wait_all_elements_visible(self, locator):
        return Wait(Driver().get_instance(), self.timeout).until(EC.visibility_of_all_elements_located(locator))

    def wait_element_present(self, locator):
        return Wait(Driver().get_instance(), self.timeout).until(EC.presence_of_element_located(locator))

    def wait_all_elements_present(self, locator):
        return Wait(Driver().get_instance(), self.timeout).until(EC.presence_of_all_elements_located(locator))

    def wait_alert_present(self):
        return Wait(Driver().get_instance(), self.timeout).until(EC.alert_is_present())
