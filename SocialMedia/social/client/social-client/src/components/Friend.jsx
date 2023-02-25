import { PersonAddOutlined, PersonRemoveOutlined } from "@mui/icons-material";
import { Box, IconButton, Typography, useTheme } from "@mui/material";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { setFriends } from "../state";
import FlexBetween from "./FlexBetween";
import UserImage from "./UserImage";

const Friend = ({ friendId, name, subtitle, userPicturePath }) => {
  return (
    <FlexBetween>
      <FlexBetween gap="1rem">
        <UserImage image={userPicturePath} size="55px" />
        <Box>
          <Typography
            color="primary"
            variant="h5"
            fontWeight="500"
            sx={{
              "&:hover": {
                color: "primary.main",
                cursor: "pointer",
              },
            }}
          >
            {name}
          </Typography>
          <Typography variant="subtitle2">{subtitle}</Typography>
        </Box>
      </FlexBetween>
    </FlexBetween>
  );
};

export default Friend;
