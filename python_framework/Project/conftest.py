import pytest
from Framework.Browser.driver import Driver
from Framework.Utils.logger import Logger


@pytest.fixture(autouse=True)
def start_exit_driver(request):
    Logger.catch_info(f'Start test: {request.node.name}')
    Driver().get_instance()
    yield Driver().get_instance()
    Driver().driver_quit()
    Logger.catch_info(f'End test: {request.node.name}\n')
