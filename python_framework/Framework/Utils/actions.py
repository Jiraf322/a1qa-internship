from faker import Faker
from selenium.webdriver import ActionChains

from Framework.Utils.waits import Waits
from selenium.common import NoSuchElementException
from Framework.Browser.driver import Driver
from Framework.Utils.logger import Logger


class Actions:

    @staticmethod
    def click_on_element(locator):
        Waits().wait_element_clickable(locator).click()

    @staticmethod
    def hover_on_element(locator):
        Waits().wait_alert_present()
        ActionChains(Driver().get_instance()).move_to_element(locator).perform()

    @staticmethod
    def get_data(locator, data=None):
        """Если ничего не указывать в data, то функция будет работать,
        как get_text(), в другом случае будет работать, как get_attribute()"""
        if data is None:
            return Waits().wait_element_present(locator).text
        else:
            return Waits().wait_element_present(locator).get_attribute(data)

    @staticmethod
    def send_text(locator, text):
        Waits().wait_element_present(locator).send_keys(text)

    @staticmethod
    def is_element_visible(locator):
        try:
            Waits().wait_element_present(locator)
            return True
        except NoSuchElementException:
            return False

    @staticmethod
    def get_random_name():
        return Faker().name()


