using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using Windows.Foundation;
using Windows.Foundation.Collections;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;

using Windows.Media.Capture;
using Windows.Storage;
using Windows.Storage.Streams;
using Windows.UI.Xaml.Media.Imaging;

using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Navigation;
using System;

using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Navigation;
using System;
using System.Linq;
using System.Collections.Generic;
using Windows.Foundation;
using Windows.Foundation.Collections;
using Windows.Graphics.Display;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Media;
using Windows.Security.Credentials.UI; 


// The Blank Page item template is documented at http://go.microsoft.com/fwlink/?LinkId=234238

namespace TextStoryApp
{
    /// <summary>
    /// An empty page that can be used on its own or navigated to within a Frame.
    /// </summary>
    public sealed partial class MainPage : Page
    {
        public MainPage()
        {
            this.InitializeComponent();
        }

        private async void btnInsetPicture_Click(object sender, RoutedEventArgs e)
        {
            
            CameraCaptureUI capture = new CameraCaptureUI();
            capture.PhotoSettings.CroppedAspectRatio = new Size(16, 9);
            StorageFile file = await capture.CaptureFileAsync(CameraCaptureUIMode.Photo);
            IRandomAccessStream filestream = await file.OpenAsync(FileAccessMode.Read);
            BitmapImage img = new BitmapImage();
            img.SetSource(filestream);
            img_viewer.Source = img;
            MessageDialog dlg = new MessageDialog("Message"); await dlg.ShowAsync();
            

            /*
            string message, title, defaultValue;
            string myValue;
            message = "Enter Message Here :";
            title = "Title Name";
            myValue = Interaction.InputBox(message, title, defaultValue, 450, 450);
            */

            



        }

        private void img_viewer_DragEnter(object sender, DragEventArgs e)
        {

        }

        //--------------------------------------------------------------------------



    }
}
