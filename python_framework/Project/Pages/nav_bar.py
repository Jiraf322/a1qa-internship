from selenium.webdriver.common.by import By

from Framework.Pages.base_page import BasePage
from Framework.Elements.button import Button


class NavBar(BasePage):

    UNIQ_LOCATOR = (By.ID, 'app')
    BUTTON_ALERT_DROPDOWN = (By.XPATH, "//*[@class='text' and text()='Alerts']")
    BUTTON_NESTED_DROPDOWN = (By.XPATH, "//*[@class='text' and text()='Nested Frames']")
    BUTTON_WEB_TABLES_DROPDOWN = (By.XPATH, "//*[@class='text' and text()='Web Tables']")
    BUTTON_LINKS_DROPDOWN = (By.XPATH, "//*[@class = 'text' and text() = 'Links']")
    BUTTON_BR_WIN_DROPDOWN = (By.XPATH, "//*[@class='text' and text()='Browser Windows']")
    BUTTON_FRAMES_DROPDOWN = (By.XPATH, "//*[@class='text' and text()='Frames']")

    BUTTON_ELEMENTS = (By.XPATH, "//*[@class = 'header-text' and text() = 'Elements']")

    def __init__(self):
        super().__init__(locator=self.UNIQ_LOCATOR, name=self.__class__.__name__)
        self.button_alert_dropdown = Button(self.BUTTON_ALERT_DROPDOWN, 'button_alert_dropdown')
        self.button_nested_frames_dropdown = Button(self.BUTTON_NESTED_DROPDOWN, 'button_nested_frames_dropdown')
        self.button_web_tables_dropdown = Button(self.BUTTON_WEB_TABLES_DROPDOWN, 'button_web_tables_dropdown')
        self.button_links_dropdown = Button(self.BUTTON_LINKS_DROPDOWN, 'button_links_dropdown')
        self.button_br_win_dropdown = Button(self.BUTTON_BR_WIN_DROPDOWN, 'button_browser_windows_dropdown')
        self.button_frames_dropdown = Button(self.BUTTON_FRAMES_DROPDOWN, 'button_frames_dropdown')

        self.button_elements = Button(self.BUTTON_ELEMENTS, 'button_elements_dropdown')

    def is_page_open(self):
        return super(NavBar, self).is_page_open()

    def click_button_alert_dropdown(self):
        self.button_alert_dropdown.click()

    def click_button_nested_frames_dropdown(self):
        self.button_nested_frames_dropdown.click()

    def click_button_web_tables_dropdown(self):
        self.button_web_tables_dropdown.click()

    def click_button_elements(self):
        self.button_elements.click()

    def click_button_links_dropdown(self):
        self.button_links_dropdown.click()

    def click_browser_windows_dropdown(self):
        self.button_br_win_dropdown.click()

    def click_button_frames_dropdown(self):
        self.button_frames_dropdown.click()
