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


using Windows.Graphics.Display;
using Windows.UI.ViewManagement;

using Windows.Security.Credentials.UI; 


// The Blank Page item template is documented at http://go.microsoft.com/fwlink/?LinkId=234238

namespace TextStoryApp
{
    /// <summary>
    /// An empty page that can be used on its own or navigated to within a Frame.
    /// </summary>
    public sealed partial class MainPage : Page
    {
        

        private bool lastImgOnLeft = false;

        Grid newGrid;

        public MainPage()
        {
            this.InitializeComponent();
        }

        /// <summary>
        /// This method create new grit 4x4
        /// </summary>
        private void createNewGrid()
        {
            
            // Create the Grid
            newGrid = new Grid();
            newGrid.HorizontalAlignment = HorizontalAlignment.Left;
            newGrid.VerticalAlignment = VerticalAlignment.Top;

            // Define the Columns
            ColumnDefinition colDef1 = new ColumnDefinition();
            ColumnDefinition colDef2 = new ColumnDefinition();

            newGrid.ColumnDefinitions.Add(colDef1);
            newGrid.ColumnDefinitions.Add(colDef2);

            // Define the Rows
            RowDefinition rowDef1 = new RowDefinition();
            RowDefinition rowDef2 = new RowDefinition();

            rowDef1.Height = new GridLength(0.8, GridUnitType.Star);
            rowDef2.Height = new GridLength(0.2, GridUnitType.Star);
            newGrid.RowDefinitions.Add(rowDef1);
            newGrid.RowDefinitions.Add(rowDef2);
        }


        private async void btnInsetPicture_Click(object sender, RoutedEventArgs e)
        {

            int gridCollumToInsert = 1;//Select columt to insert photo and text
                                        //0 for left colum, 1 to right colum

            //Create new grid if is inserted 2 photo
            if (!lastImgOnLeft)
            {
                createNewGrid();
                gridCollumToInsert = 0;
            }

            //Create photo using camera
            CameraCaptureUI capture = new CameraCaptureUI();
            capture.PhotoSettings.CroppedAspectRatio = new Size(16, 9);
            StorageFile file = await capture.CaptureFileAsync(CameraCaptureUIMode.Photo);
            IRandomAccessStream filestream = await file.OpenAsync(FileAccessMode.Read);
            BitmapImage img = new BitmapImage();
            img.SetSource(filestream);

            Image img_viewer = new Image();
            img_viewer.Source = img;
            
            //Insert photo into grid
            img_viewer.SetValue(Grid.ColumnProperty, gridCollumToInsert);
            img_viewer.SetValue(Grid.RowProperty, 0);
            newGrid.Children.Add(img_viewer);

            //Get text to photo description
            InputMessageDialog dlg = new InputMessageDialog("Write photo story:");
            bool result = await dlg.ShowAsync();
            if (result != false)
            {
                string userInput = dlg.TextBox.Text;
                TextBox description = new TextBox();
                description.Text = userInput;
                
                //Insert text description to grid
                description.SetValue(Grid.ColumnProperty, gridCollumToInsert);
                description.SetValue(Grid.RowProperty, 1);
                newGrid.Children.Add(description);
               
            }


            //myGrid.Children.Add(img_viewerN);
            if (!lastImgOnLeft)
            {
                myStackpanel.Children.Add(newGrid);
            }

            //Negation variable with last image position
            lastImgOnLeft = !lastImgOnLeft;
           


        }

        private void img_viewer_DragEnter(object sender, DragEventArgs e)
        {

        }

        //--------------------------------------------------------------------------



    }
}
