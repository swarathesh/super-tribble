import { Box, useMediaQuery } from "@mui/material";
import { useSelector } from "react-redux";

import MyPostWidget from "../widgets/MyPostWidget";
import PostsWidget from "../widgets/PostsWidget";

const HomePage = () => {
    const isNonMobileScreens = useMediaQuery("(min-width:1000px)");
    const { _id, picturePath } = useSelector((state) => state.user);

  

    return (
       <Box>
        <Box
           width={isNonMobileScreens ? "50%" : "100%"}
           padding={isNonMobileScreens ? "0 0 0 20px" : "0"}
           display={isNonMobileScreens ? "flex" : "block"}
           gap="0.5rem"
           justifyContent="space-between"
        >
             <MyPostWidget picturePath={picturePath} />
             <PostsWidget userId={_id} />
                
        </Box>
       </Box>
    );

};


export default HomePage;