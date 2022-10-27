from selenium.webdriver.common.by import By

from Framework.Pages.base_page import BasePage
from Framework.Elements.button import Button
from Framework.Elements.label import Label
from Framework.Browser.driver_utils import DriverUtils


class FramesPage(BasePage):

    UNIQ_LOCATOR = (By.ID, 'app')
    HEADER = (By.XPATH, "//*[@class = 'main-header']")
    BUTTON_FRAMES_DROPDOWN = (By.XPATH, "//*[@class='text' and text()='Frames']")
    BIG_FRAME = (By.ID, 'frame1')
    SMALL_FRAME = (By.ID, 'frame2')
    INSIDE_FRAME = (By.ID, 'sampleHeading')

    def __init__(self):
        super().__init__(locator=self.UNIQ_LOCATOR, name=self.__class__.__name__)
        self.button_frames_dropdown = Button(self.BUTTON_FRAMES_DROPDOWN, 'button_frames_dropdown')
        self.label_frames = Label(self.HEADER, 'label_frames')
        self.label_inside_frame = Label(self.INSIDE_FRAME, 'label_inside_frame')

    def is_page_open(self):
        return super(FramesPage, self).is_page_open()

    def is_frames_open(self):
        if self.label_frames.get_text() == 'Frames':
            return True
        return False

    def click_button_frames_dropdown(self):
        self.button_frames_dropdown.click()

    def get_text_big_frame(self):
        DriverUtils.switch_to_frame(self.BIG_FRAME)
        data = self.label_inside_frame.get_text()
        DriverUtils.switch_to_default()
        return data

    def get_text_small_frame(self):
        DriverUtils.switch_to_frame(self.SMALL_FRAME)
        data = self.label_inside_frame.get_text()
        DriverUtils.switch_to_default()
        return data

