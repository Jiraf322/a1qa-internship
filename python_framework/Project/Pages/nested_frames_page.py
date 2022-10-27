from selenium.webdriver.common.by import By

from Framework.Browser.driver_utils import DriverUtils
from Framework.Pages.base_page import BasePage
from Framework.Elements.label import Label


class NestedFramesPage(BasePage):

    UNIQ_LOCATOR = (By.ID, 'app')
    HEADER = (By.XPATH, "//*[@class = 'main-header']")

    PARENT_FRAME = (By.CSS_SELECTOR, 'iframe[id="frame1"]')
    PARENT_TEXT = (By.CSS_SELECTOR, 'body')
    CHILD_FRAME = (By.CSS_SELECTOR, 'iframe[srcdoc="<p>Child Iframe</p>"]')
    CHILD_TEXT = (By.CSS_SELECTOR, 'p')

    def __init__(self):
        super().__init__(locator=self.UNIQ_LOCATOR, name=self.__class__.__name__)
        self.label_nested_frames = Label(self.HEADER, 'label_nested_frames')
        self.label_parent_frame = Label(self.PARENT_TEXT, 'label_parent_frame')
        self.label_child_frame = Label(self.CHILD_TEXT, 'label_child_frame')

    def is_page_open(self):
        return super(NestedFramesPage, self).is_page_open()

    def is_nested_frames_open(self):
        if self.label_nested_frames.get_text() == 'Nested Frames':
            return True
        return False

    def get_text_nested_parent_frame(self):
        DriverUtils.switch_to_frame(self.PARENT_FRAME)
        return self.label_parent_frame.get_text()

    def get_text_nested_child_frame(self):
        DriverUtils.switch_to_frame(self.PARENT_FRAME)
        parent = self.label_parent_frame.get_text()
        DriverUtils.switch_to_frame(self.CHILD_FRAME)
        child = self.label_parent_frame.get_text()
        DriverUtils.switch_to_default()
        return parent, child


