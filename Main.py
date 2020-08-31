import sys
from PyQt5 import QtWidgets

# MainWindow class
class MainWindow(QtWidgets.QMainWindow):

    def __init__(self):
        """
        Initializes the main window.
        Loads in a UI file to act as a base and assigns methods to all the buttons.
        """
        super(MainWindow, self).__init__()
        # Import UI once finished with: uic.loadUi('xxx', self)
        self.show()

# Launcher area
if __name__ == '__main__':
    # App is the running mechanism, window is a local argument that will internally passed along when we execute
    app = QtWidgets.QApplication(sys.argv)
    window = MainWindow()
    # Surround in a try/except so that when the program exits we don't have errors popping up
    try:
        # app.exec_() runs the GUI.
        sys.exit(app.exec_())
    except:
        pass