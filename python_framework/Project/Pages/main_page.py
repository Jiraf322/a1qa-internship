from selenium.webdriver.common.by import By

from Framework.Browser.driver_utils import DriverUtils
from Framework.Pages.base_page import BasePage
from Framework.Elements.button import Button


class MainPage(BasePage):

    UNIQ_LOCATOR = (By.XPATH, "//*[@class = 'home-content']")
    BUTTON_ALERT = (By.XPATH, "//div[@class = 'card mt-4 top-card'][3]//div[@class='card-up']")
    BUTTON_ELEMENTS = (By.XPATH, "//*[@class = 'card mt-4 top-card'][1]//div[@class='card-up']")

    def __init__(self):
        super().__init__(locator=self.UNIQ_LOCATOR, name=self.__class__.__name__)
        self.button_alerts = Button(self.BUTTON_ALERT, 'button_alert')
        self.button_elements = Button(self.BUTTON_ELEMENTS, 'button_elements')

    def is_page_open(self):
        return super(MainPage, self).is_page_open()

    def go_to_the_alerts_frame_windows(self):
        self.button_alerts.click()

    def go_to_the_elements(self):
        self.button_elements.click()

    @staticmethod
    def remove_footer_ad():
        DriverUtils.get_js_executor("document.getElementsByTagName('footer')[0].remove()")
        DriverUtils.get_js_executor("document.getElementById('fixedban').remove()")

