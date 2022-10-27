from selenium.webdriver.common.by import By

from Framework.Pages.base_page import BasePage
from Framework.Elements.button import Button
from Framework.Elements.label import Label


class AlertPage(BasePage):

    UNIQ_LOCATOR = (By.ID, 'app')
    BUTTON_SEE_ALERT = (By.ID, 'alertButton')
    BUTTON_CONFIRM_ALERT = (By.ID, 'confirmButton')
    LABEL_OK = (By.ID, 'confirmResult')
    BUTTON_PROMPT_ALERT = (By.ID, 'promtButton')
    LABEL_PROMPT = (By.ID, 'promptResult')
    HEADER_ALERT = (By.XPATH, "//*[@class = 'main-header']")

    def __init__(self):
        super().__init__(locator=self.UNIQ_LOCATOR, name=self.__class__.__name__)
        self.see_alert = Button(self.BUTTON_SEE_ALERT, 'button_see_alert')
        self.confirm_alert = Button(self.BUTTON_CONFIRM_ALERT, 'button_confirm_alert')
        self.label_select_ok = Label(self.LABEL_OK, 'label_ok')
        self.prompt_alert = Button(self.BUTTON_PROMPT_ALERT, 'button_alert_promt')
        self.label_prompt = Label(self.LABEL_PROMPT, 'label_prompt')
        self.label_alerts = Label(self.HEADER_ALERT, 'label_alerts')

    def is_page_open(self):
        super(AlertPage, self).is_page_open()

    def is_alerts_open(self):
        if self.label_alerts.get_text() == 'Alerts':
            return True
        return False

    def click_see_alert_button(self):
        self.see_alert.click()

    def click_confirm_alert_button(self):
        self.confirm_alert.click()

    def is_alert_label_ok(self):
        if self.label_select_ok.get_text() == 'You selected Ok':
            return True
        return False

    def click_alert_prompt_button(self):
        self.prompt_alert.click()

    def get_label_prompt_text(self):
        return self.label_prompt.get_text()
