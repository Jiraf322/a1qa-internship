from selenium.webdriver.common.by import By

from Framework.Pages.base_page import BasePage
from Framework.Elements.button import Button
from Framework.Elements.label import Label
from Framework.Browser.driver_utils import DriverUtils


class LinksPage(BasePage):

    UNIQ_LOCATOR = (By.ID, 'app')
    HEADER = (By.XPATH, "//*[@class = 'main-header']")
    BUTTON_HOME_LINK = (By.ID, 'simpleLink')

    def __init__(self):
        super().__init__(locator=self.UNIQ_LOCATOR, name=self.__class__.__name__)
        self.label_frames = Label(self.HEADER, 'label_frames')
        self.label_browser_windows = Label(self.HEADER, 'label_web_tables')
        self.button_home_link = Button(self.BUTTON_HOME_LINK, 'button_home_link')

    def is_page_open(self):
        return super(LinksPage, self).is_page_open()

    def is_links_open(self):
        if self.label_browser_windows.get_text() == 'Links':
            return True
        return False

    # TODO: вынести отдельно
    @staticmethod
    def switch_to_new_page():
        DriverUtils().go_to_window(-1)

    @staticmethod
    def switch_to_main_page():
        DriverUtils().go_to_window()

    def click_button_home_link(self):
        self.button_home_link.click()
