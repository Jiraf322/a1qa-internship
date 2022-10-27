from selenium.common import NoAlertPresentException

from Framework.Browser.driver import Driver
from Framework.Resources.json_path import JsonPath
from Framework.Utils.json_getter import JsonGetter
from Framework.Utils.logger import Logger
from Framework.Utils.waits import Waits

from Project.Resources.person import Person


class DriverUtils:

    @staticmethod
    def go_to_base_url():

        browser_config_path = JsonPath.framework_config
        try:
            Logger.catch_info(f'going to the {JsonGetter().get_data(data_1="url", path=browser_config_path)}')
            Driver().get_instance().get(url=JsonGetter().get_data(data_1="url", path=browser_config_path))
        except Exception as ex:
            Logger.catch_warning(
                f'failed to go to {JsonGetter().get_data(data_1="url", path=browser_config_path)} during {ex}')

    @staticmethod
    def get_frame(windowID):
        try:
            Logger.catch_info(f'getting to the frame with ID: {windowID}')
            Driver().get_instance().switch_to.frame(windowID)
        except Exception as ex:
            Logger.catch_warning(f'failed to get the frame with ID: {windowID} during {ex} ')

    @staticmethod
    def close_current_window():
        Driver().get_instance().close()

    @staticmethod
    def get_window_handles():
        return Driver().get_instance().window_handles

    def go_to_window(self, index=0):
        Driver().get_instance().switch_to.window(self.get_window_handles()[index])

    @staticmethod
    def get_current_url():
        return Driver().get_instance().current_url

    @staticmethod
    def switch_to_alert():
        try:
            Logger.catch_info(f'switching to alert')
            return Driver().get_instance().switch_to.alert
        except Exception as ex:
            Logger.catch_warning(f'failed to switch to alert during {ex}')

    @staticmethod
    def get_js_executor(script):
        try:
            Logger.catch_info(f'executing JS code: {script}')
            Driver().get_instance().execute_script(script)
        except Exception as ex:
            Logger.catch_warning(f'failed to execute JS code: {script} during {ex}')

    def take_screenshot(self):
        pass

    @staticmethod
    def accept_alert():
        try:
            Logger.catch_info(f'accepting alert')
            Waits().wait_alert_present()
            Driver().get_instance().switch_to.alert.accept()
        except Exception as ex:
            Logger.catch_warning(f'failed to accept alert during {ex}')

    @staticmethod
    def dismiss_alert():
        try:
            Logger.catch_info(f'dismissing alert')
            Waits().wait_alert_present()
            Driver().get_instance().switch_to.alert.dismiss()
        except Exception as ex:
            Logger.catch_warning(f'failed to dismiss alert during {ex}')

    def send_text_alert(self, text: str):
        try:
            Logger.catch_info(f'sending text to alert')
            self.switch_to_alert().send_keys(text)
        except Exception as ex:
            Logger.catch_warning(f'failed to send text to alert during {ex}')

    @staticmethod
    def is_alert_present():
        try:
            Logger.catch_info(f'searching for alert')
            temp = Driver().get_instance().switch_to.alert
            del temp
            return True
        except NoAlertPresentException:
            Logger.catch_info(f'alert has not been found')
            return False

    @staticmethod
    def get_users():
        path = JsonPath.project_persons
        # path = r'C:\Users\USER\OneDrive\Рабочий стол\last_task\Project\Resources\persons.json'

        persons_dict = JsonGetter.get_data(path=path, data_1='person')

        persons = []

        for person in persons_dict:
            new_person = Person(
                first_name=persons_dict[person]['first_name'],
                last_name=persons_dict[person]['last_name'],
                email=persons_dict[person]['email'],
                age=persons_dict[person]['age'],
                salary=persons_dict[person]['salary'],
                department=persons_dict[person]['department']
            )
            persons.append(new_person)

        return persons

    @staticmethod
    def refresh_page():
        try:
            Logger.catch_info(f'refreshing page')
            Driver().get_instance().refresh()
        except Exception as ex:
            Logger.catch_warning(f'can not refresh page due to {ex}')

    @staticmethod
    def switch_to_default():
        try:
            Logger.catch_info(f'switching to default frame')
            Driver().get_instance().switch_to.default_content()
        except Exception as ex:
            Logger.catch_info(f'can not switch to default frame due to {ex}')

    @staticmethod
    def switch_to_frame(locator):
        try:
            Logger.catch_info(f'switching to frame by locator: {locator}')
            Driver().get_instance().switch_to.frame(Waits().wait_element_present(locator))
        except Exception as ex:
            Logger.catch_warning(f'can not switch to frame by locator: {locator} due to {ex}')
