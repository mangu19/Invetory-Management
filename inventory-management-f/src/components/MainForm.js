import React, { useState } from 'react'

export default function MainForm() {
    
  const [imagePreviewUrl, setImagePreviewUrl] = useState('');
  const handleImageChange = (e) => {
    
    const file = e.target.files[0];
    if (file) {
      resizeImage(file, 300, 300, (resizedImageUrl) => {
        setImagePreviewUrl(resizedImageUrl);
      });
      
    }
  };

  const resizeImage = (file, maxWidth, maxHeight, callback) => {
    const reader = new FileReader();
    reader.onload = (e) => {
      const img = new Image();
      img.onload = () => {
        const canvas = document.createElement('canvas');
        let width = img.width;
        let height = img.height;

        // Calculate the new dimensions while maintaining the aspect ratio
        if (width > height) {
          if (width > maxWidth) {
            height = Math.round((height *= maxWidth / width));
            width = maxWidth;
          }
        } else {
          if (height > maxHeight) {
            width = Math.round((width *= maxHeight / height));
            height = maxHeight;
          }
        }

        canvas.width = width;
        canvas.height = height;
        const ctx = canvas.getContext('2d');
        ctx.drawImage(img, 0, 0, width, height);
        document.getElementById('imgFile').style.display='block';
        // Get the data URL of the resized image
        const resizedImageUrl = canvas.toDataURL('image/jpeg');
        callback(resizedImageUrl);
      };
      img.src = e.target.result;
    };
    reader.readAsDataURL(file);
  };
  return(
    <>
        <div class="container my-5" style={{width:"500px"}}>
            
        <div class="form-floating mb-3">
  <input type="text" class="form-control" name='productName' id="floatingInput"  /> 
  <label for="floatingInput">Product Name</label>
</div>
<div class="form-floating mb-3">
  <input type="text" class="form-control" name='description' id="floatingPassword" />
  <label for="floatingPassword">Description</label>
</div>
<div class="form-floating mb-3">
  <input type="text" class="form-control" id="floatingInput" name='status'  />
  <label for="floatingInput">Status</label>
</div>

            <div class="input-group mb-3">
                <label class="input-group-text" for="inputGroupFile01">Upload</label>
                <input type="file" class="form-control" name='file' id="inputGroupFile01" onChange={handleImageChange}/>
            </div>

        <img src={imagePreviewUrl} id='imgFile' class="img-thumbnail" alt="Selected" style={{ maxWidth: '100%', height: 'auto', display:'none' }} />
        </div>
        
    
    
    
    </>
  )
}
