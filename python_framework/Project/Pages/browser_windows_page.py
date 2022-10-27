from selenium.webdriver.common.by import By

from Framework.Pages.base_page import BasePage
from Framework.Elements.button import Button
from Framework.Elements.label import Label
from Framework.Browser.driver_utils import DriverUtils


class BrowserWindowsPage(BasePage):

    UNIQ_LOCATOR = (By.ID, 'app')
    HEADER = (By.XPATH, "//*[@class = 'main-header']")
    BUTTON_NEW_TAB = (By.ID, "tabButton")

    def __init__(self):
        super().__init__(locator=self.UNIQ_LOCATOR, name=self.__class__.__name__)
        self.label_frames = Label(self.HEADER, 'label_frames')
        self.label_browser_windows = Label(self.HEADER, 'label_web_tables')
        self.button_new_tab = Button(self.BUTTON_NEW_TAB, 'button_new_tab')

    def is_page_open(self):
        return super(BrowserWindowsPage, self).is_page_open()

    def is_browser_windows_open(self):
        if self.label_browser_windows.get_text() == 'Browser Windows':
            return True
        return False

    def click_button_new_tab(self):
        self.button_new_tab.click()

    @staticmethod
    def is_sample_page_open():
        DriverUtils.get_window_handles()
        url = DriverUtils.get_current_url()
        if r'/sample' in url:
            return True
        return False

    @staticmethod
    def switch_to_new_page():
        DriverUtils().go_to_window(-1)

    @staticmethod
    def switch_to_main_page():
        DriverUtils().go_to_window()

