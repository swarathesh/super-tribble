import { PersonAddOutlined, PersonRemoveOutlined } from "@mui/icons-material";
import { Box, IconButton, Typography, useTheme } from "@mui/material";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { setFriends } from "../state";
import FlexBetween from "./FlexBetween";
import UserImage from "./UserImage";

const Friend = ({ friendId, name, subtitle, userPicturePath}) => {

   return (
     <FlexBetween>
        <FlexBetween>
              <UserImage picturePath={userPicturePath} />
              <Box>
                <Typography variant="h6">{name}</Typography>
                <Typography variant="subtitle2">{subtitle}</Typography>
              </Box>
        </FlexBetween>
     </FlexBetween>
   );


};

export default Friend;
